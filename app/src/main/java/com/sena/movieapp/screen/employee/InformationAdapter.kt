package com.sena.movieapp.screen.employee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sena.movieapp.R
import com.sena.movieapp.base.model.EmployeeInformation
import kotlinx.android.synthetic.main.item_employee_information.view.*

class InformationAdapter(private val  employeeList: List<EmployeeInformation>) :
    RecyclerView.Adapter<InformationAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee_information,parent,false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int = employeeList.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(employeeInformation:EmployeeInformation){
            itemView.apply {
                item_employee_fullname.text = employeeInformation.employeeName
                item_employee_age.text = employeeInformation.employeeAge
                item_employee_salary.text = employeeInformation.employeeSalary
            }
        }
    }
}