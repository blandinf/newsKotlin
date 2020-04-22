package com.blandinf.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.blandinf.kotlinproject.fragments.ArticlesFragment
import com.blandinf.kotlinproject.fragments.CategoryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchToFragment(CategoryFragment())
    }
}

fun FragmentActivity.switchToFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.container, fragment)
        addToBackStack(null)
    }.commit()
}
