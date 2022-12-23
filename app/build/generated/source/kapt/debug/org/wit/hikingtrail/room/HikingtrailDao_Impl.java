package org.wit.hikingtrail.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.wit.hikingtrail.models.HikingtrailModel;
import org.wit.hikingtrail.models.Location;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HikingtrailDao_Impl implements HikingtrailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HikingtrailModel> __insertionAdapterOfHikingtrailModel;

  private final EntityDeletionOrUpdateAdapter<HikingtrailModel> __deletionAdapterOfHikingtrailModel;

  private final EntityDeletionOrUpdateAdapter<HikingtrailModel> __updateAdapterOfHikingtrailModel;

  public HikingtrailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHikingtrailModel = new EntityInsertionAdapter<HikingtrailModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `HikingtrailModel` (`id`,`fbId`,`title`,`description`,`difficulty`,`rating`,`image`,`lat`,`lng`,`zoom`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HikingtrailModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getFbId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFbId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getDifficulty() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDifficulty());
        }
        if (value.getRating() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRating());
        }
        if (value.getImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          stmt.bindDouble(8, _tmpLocation.getLat());
          stmt.bindDouble(9, _tmpLocation.getLng());
          stmt.bindDouble(10, _tmpLocation.getZoom());
        } else {
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
      }
    };
    this.__deletionAdapterOfHikingtrailModel = new EntityDeletionOrUpdateAdapter<HikingtrailModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `HikingtrailModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HikingtrailModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfHikingtrailModel = new EntityDeletionOrUpdateAdapter<HikingtrailModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `HikingtrailModel` SET `id` = ?,`fbId` = ?,`title` = ?,`description` = ?,`difficulty` = ?,`rating` = ?,`image` = ?,`lat` = ?,`lng` = ?,`zoom` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HikingtrailModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getFbId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFbId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getDifficulty() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDifficulty());
        }
        if (value.getRating() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRating());
        }
        if (value.getImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          stmt.bindDouble(8, _tmpLocation.getLat());
          stmt.bindDouble(9, _tmpLocation.getLng());
          stmt.bindDouble(10, _tmpLocation.getZoom());
        } else {
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
        stmt.bindLong(11, value.getId());
      }
    };
  }

  @Override
  public Object create(final HikingtrailModel hikingtrail,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHikingtrailModel.insert(hikingtrail);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteHikingtrail(final HikingtrailModel hikingtrail,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfHikingtrailModel.handle(hikingtrail);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final HikingtrailModel hikingtrail,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfHikingtrailModel.handle(hikingtrail);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object findAll(final Continuation<? super List<HikingtrailModel>> continuation) {
    final String _sql = "SELECT * FROM HikingtrailModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<HikingtrailModel>>() {
      @Override
      public List<HikingtrailModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFbId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
          final int _cursorIndexOfZoom = CursorUtil.getColumnIndexOrThrow(_cursor, "zoom");
          final List<HikingtrailModel> _result = new ArrayList<HikingtrailModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HikingtrailModel _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFbId;
            if (_cursor.isNull(_cursorIndexOfFbId)) {
              _tmpFbId = null;
            } else {
              _tmpFbId = _cursor.getString(_cursorIndexOfFbId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final Location _tmpLocation;
            if (! (_cursor.isNull(_cursorIndexOfLat) && _cursor.isNull(_cursorIndexOfLng) && _cursor.isNull(_cursorIndexOfZoom))) {
              final double _tmpLat;
              _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
              final double _tmpLng;
              _tmpLng = _cursor.getDouble(_cursorIndexOfLng);
              final float _tmpZoom;
              _tmpZoom = _cursor.getFloat(_cursorIndexOfZoom);
              _tmpLocation = new Location(_tmpLat,_tmpLng,_tmpZoom);
            }  else  {
              _tmpLocation = null;
            }
            _item = new HikingtrailModel(_tmpId,_tmpFbId,_tmpTitle,_tmpDescription,_tmpDifficulty,_tmpRating,_tmpImage,_tmpLocation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object findById(final long id, final Continuation<? super HikingtrailModel> continuation) {
    final String _sql = "select * from HikingtrailModel where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<HikingtrailModel>() {
      @Override
      public HikingtrailModel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFbId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
          final int _cursorIndexOfZoom = CursorUtil.getColumnIndexOrThrow(_cursor, "zoom");
          final HikingtrailModel _result;
          if(_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFbId;
            if (_cursor.isNull(_cursorIndexOfFbId)) {
              _tmpFbId = null;
            } else {
              _tmpFbId = _cursor.getString(_cursorIndexOfFbId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final Location _tmpLocation;
            if (! (_cursor.isNull(_cursorIndexOfLat) && _cursor.isNull(_cursorIndexOfLng) && _cursor.isNull(_cursorIndexOfZoom))) {
              final double _tmpLat;
              _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
              final double _tmpLng;
              _tmpLng = _cursor.getDouble(_cursorIndexOfLng);
              final float _tmpZoom;
              _tmpZoom = _cursor.getFloat(_cursorIndexOfZoom);
              _tmpLocation = new Location(_tmpLat,_tmpLng,_tmpZoom);
            }  else  {
              _tmpLocation = null;
            }
            _result = new HikingtrailModel(_tmpId,_tmpFbId,_tmpTitle,_tmpDescription,_tmpDifficulty,_tmpRating,_tmpImage,_tmpLocation);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
