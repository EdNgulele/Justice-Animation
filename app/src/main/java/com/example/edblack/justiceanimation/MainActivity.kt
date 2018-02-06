package com.example.edblack.justiceanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var selectedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animateConstraints()
    }

    private fun animateConstraints() {
        main_layout.setOnClickListener { defaultLayout() }

        wonderwoman_img.setOnClickListener {
            if (selectedView != wonderwoman_img) {
                updateLayout(R.layout.activity_main_wonderwoman)
                selectedView = wonderwoman_img
            }
        }

        superman_img.setOnClickListener {
            if (selectedView != superman_img) {
                updateLayout(R.layout.activity_main_superman)
                selectedView = superman_img
            }
        }

        batman_img.setOnClickListener {
            if (selectedView != batman_img) {
                updateLayout(R.layout.activity_main_batman)
                selectedView = batman_img
            }
        }
    }

    private fun defaultLayout() {
        if (selectedView != null) {
            updateLayout(R.layout.activity_main)
            selectedView = null
        }
    }

    private fun updateLayout(@LayoutRes id: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, id)
        constraintSet.applyTo(main_layout)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(main_layout, transition)

    }
}
