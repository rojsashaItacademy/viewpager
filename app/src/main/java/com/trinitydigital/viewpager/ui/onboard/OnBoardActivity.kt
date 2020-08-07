package com.trinitydigital.viewpager.ui.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.trinitydigital.viewpager.R
import com.trinitydigital.viewpager.data.OnBoardModel
import com.trinitydigital.viewpager.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    private val list = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        onBoardViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (isLastPage(position)) {
                    btnNext.text = "Завершить"
                } else {
                    btnNext.text = "Продолжить"
                }
            }

        })

        btnNext.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
//                onBoardViewPager.currentItem = onBoardViewPager.currentItem + 1
                onBoardViewPager.currentItem += 1
            }
        }
    }

    private fun isLastPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(supportFragmentManager)
        onBoardViewPager.adapter = adapter

        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.images, "sasha12", "1")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.images, "sasha12", "2")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.images, "sasha12", "3")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.images, "sasha12", "4")))
        adapter.update(list)
        onBoardTabLayout.setupWithViewPager(onBoardViewPager)
    }
}