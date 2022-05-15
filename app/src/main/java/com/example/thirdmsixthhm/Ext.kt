package com.example.thirdmsixthhm

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.text.CaseMap
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import kotlin.reflect.KFunction1

fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()

}

fun Context.showContext(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showContext(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun FragmentActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
}

fun FragmentActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null)
        .commit()
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun Fragment.showAlert(title: String, items: Int, onClick:(pos:Int) ->Unit) {
    val alertDialogBuilder = AlertDialog.Builder(requireContext())
    alertDialogBuilder.setTitle(title)
    alertDialogBuilder.setItems(
        items
    ) { p0, pos ->
onClick(pos)

    }
    alertDialogBuilder.create().show()
}