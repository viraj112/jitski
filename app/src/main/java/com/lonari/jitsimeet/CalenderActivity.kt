package com.lonari.jitsimeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_calender.*

class CalenderActivity : AppCompatActivity() {
    var listData: ArrayList<Model> = ArrayList()
    lateinit var meetingAdapter: MeetingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        rv_meet.layoutManager = LinearLayoutManager(this)
        listData.add(Model("2022 AGM Meeting","1.Meeting open,2.Meeting Details","Started"))
        listData.add(Model("2022 AGM Meeting","1.Meeting open,2.Meeting Details","Started"))
        meetingAdapter = MeetingAdapter(this,listData)
        rv_meet.adapter = meetingAdapter

    }
}