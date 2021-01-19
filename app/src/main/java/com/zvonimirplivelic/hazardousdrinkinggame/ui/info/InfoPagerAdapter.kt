package com.zvonimirplivelic.hazardousdrinkinggame.ui.info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class InfoPagerAdapter(private val context: Context): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val infoPage = InfoPagerModel.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(infoPage.layoutResId, container, false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int = InfoPagerModel.values().size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val infoPage = InfoPagerModel.values()[position]
        return context.getString(infoPage.titleResId)
    }
}