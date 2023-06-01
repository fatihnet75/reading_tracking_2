package com.example.myapplication

data class Student(val id:Int,val userName:String ,val password:String) {
    companion object{
        const val TABLE_NAME="Kullanıcılar"
        const val COLUMN_ID="id"
        const val COLUMN_USERNAME="userName"
        const val COLUMN_PASWORD="password"
    }
}