package com.sena.movieapp.screen.employee

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sena.movieapp.R
import com.sena.movieapp.base.MyAppClass
import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_employee.*

class EmployeeActivity : BaseActivity<EmployeeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyAppClass).appComponent.inject(this)
        setContentView(R.layout.activity_employee)
        observeData()
        viewModel.fetchEmployeeViewModel()
    }

    private fun observeData() {
        viewModel.employeeList.observe(this, Observer {
            initRecyclerView(it)
        })
    }

    private fun initRecyclerView(itemList: List<EmployeeInformation>){
        val informationAdapter = InformationAdapter(itemList)
        val layoutManager = LinearLayoutManager(this)
        employee_recyclerview.layoutManager = layoutManager
        employee_recyclerview.adapter = informationAdapter
    }

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, EmployeeActivity::class.java)
    }
}

