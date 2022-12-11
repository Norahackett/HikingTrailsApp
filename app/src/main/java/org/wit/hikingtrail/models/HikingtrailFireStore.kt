package org.wit.hikingtrail.models
import android.content.Context
import android.graphics.Bitmap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import org.wit.hikingtrail.readImageFromPath
import timber.log.Timber.i
import java.io.ByteArrayOutputStream
import java.io.File

class HikingtrailFireStore(val context: Context) : HikingtrailStore {
    val hikingtrails = ArrayList<HikingtrailModel>()
    lateinit var userId: String
    lateinit var db: DatabaseReference
    lateinit var st: StorageReference
    override suspend fun findAll(): List<HikingtrailModel> {
        return hikingtrails
    }

    override suspend fun findById(id: Long): HikingtrailModel? {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { t-> t.id == id }
        return foundHikingtrail
    }

    override suspend fun create(hikingtrail: HikingtrailModel) {
        val key = db.child("users").child(userId).child("hikingtrails").push().key
        key?.let {
            hikingtrail.fbId = key
            hikingtrails.add(hikingtrail)
            db.child("users").child(userId).child("hikingtrails").child(key).setValue(hikingtrail)
            updateImage(hikingtrail)
        }
    }

    override suspend fun update(hikingtrail: HikingtrailModel) {
        var foundHikingtrail: HikingtrailModel? = hikingtrails.find { t -> t.fbId == hikingtrail.fbId }
        if (foundHikingtrail != null) {
            foundHikingtrail.title = hikingtrail.title
            foundHikingtrail.description = hikingtrail.description
            foundHikingtrail.image = hikingtrail.image
            foundHikingtrail.location = hikingtrail.location
        }

        db.child("users").child(userId).child("hikingtrails").child(hikingtrail.fbId).setValue(hikingtrail)
        if(hikingtrail.image.length > 0){
            updateImage(hikingtrail)
        }
    }

    override suspend fun delete(hikingtrail: HikingtrailModel) {
        db.child("users").child(userId).child("hikingtrails").child(hikingtrail.fbId).removeValue()
        hikingtrails.remove(hikingtrail)
    }

    override suspend fun clear() {
        hikingtrails.clear()
    }

    fun fetchHikingtrails(hikingtrailsReady: () -> Unit) {
        val valueEventListener = object : ValueEventListener {
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot!!.children.mapNotNullTo(hikingtrails) {
                    it.getValue<HikingtrailModel>(
                        HikingtrailModel::class.java
                    )
                }
                hikingtrailsReady()
            }
        }
        userId = FirebaseAuth.getInstance().currentUser!!.uid
       st = FirebaseStorage.getInstance().reference
        db = FirebaseDatabase.getInstance().reference
        hikingtrails.clear()
        db.child("users").child(userId).child("hikingtrails")
            .addListenerForSingleValueEvent(valueEventListener)
    }
    fun updateImage(hikingtrail: HikingtrailModel){
        if(hikingtrail.image != ""){
            val fileName = File(hikingtrail.image)
            val imageName = fileName.getName()

            var imageRef = st.child(userId + '/' + imageName)
            val baos = ByteArrayOutputStream()
            val bitmap = readImageFromPath(context, hikingtrail.image)

            bitmap?.let {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, baos)

                val data = baos.toByteArray()
                val uploadTask = imageRef.putBytes(data)

                uploadTask.addOnSuccessListener { taskSnapshot ->
                    taskSnapshot.metadata!!.reference!!.downloadUrl.addOnSuccessListener {
                        hikingtrail.image = it.toString()
                        db.child("users").child(userId).child("hikingtrails").child(hikingtrail.fbId).setValue(hikingtrail)
                    }
                }.addOnFailureListener{
                    var errorMessage = it.message
                    i("Failure: $errorMessage")
                }
            }

        }
    }
}