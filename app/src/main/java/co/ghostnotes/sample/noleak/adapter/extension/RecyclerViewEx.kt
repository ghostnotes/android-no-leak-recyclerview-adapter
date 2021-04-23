package co.ghostnotes.sample.noleak.adapter.extension

import android.view.View
import android.view.View.OnAttachStateChangeListener
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

fun <VH : RecyclerView.ViewHolder> RecyclerView.setAdapterNoLeak(adapter: RecyclerView.Adapter<VH>) {
    this.adapter = adapter

    addOnAttachStateChangeListener(object : OnAttachStateChangeListener {
        override fun onViewAttachedToWindow(v: View?) {
            // do nothing...
        }

        override fun onViewDetachedFromWindow(v: View?) {
            Timber.d("### onViewDetachedFromWindow()")
            setAdapter(null)
        }
    })
}