package org.wit.hikingtrail.views.about

import org.wit.hikingtrail.main.MainApp


class AboutPresenter(private val view: AboutView) {
    var app: MainApp = view.application as MainApp





    fun doCancel() {
     view.finish()
    }
}