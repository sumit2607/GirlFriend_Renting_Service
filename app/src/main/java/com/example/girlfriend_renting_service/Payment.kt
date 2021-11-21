package com.example.girlfriend_renting_service

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import kotlinx.android.synthetic.main.activity_payment.*
import org.json.JSONObject
class Payment : AppCompatActivity(), PaymentResultListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        btn.setOnClickListener {
            if (makepayment()){
                val intent = Intent(this@Payment,ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun makepayment(): Boolean {

        val checkout = Checkout()
        checkout.setKeyID("rzp_test_leWM6m9wU6q5j6")

        val activity: Activity = this
        try {
            val options = JSONObject()
            options.put("name", "Nishant Rishab")
            options.put("description", "Reference No. #123456")
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            //    options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
            options.put("amount", "100") //pass amount in currency subunits
            options.put("prefill.email", "nishant.rishab@example.com")
            options.put("prefill.contact", "+918882349318")
            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)
            checkout.open(activity, options)
        } catch (e: Exception) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e)
        }
        return true
    }
    override fun onPaymentSuccess(s: String) {
        paytext!!.text = "Successful payment ID :$s"
//        val intent1 = intent
//        val intent = Intent(this@Payment,ProfileActivity::class.java)
//        intent.putExtra("image7", intent1.getStringExtra("image6"))
//        intent.putExtra("name2", intent1.getStringExtra("name1"))
//        intent.putExtra("age1", (Serializable) mTvAge);
//        intent.putExtra("location1", (Serializable) mTvLocation);
//        intent.putExtra("phone1", (Serializable) mTvPhone);
//        intent.putExtra("type1", (Serializable) mTvType);
//        intent.putExtra("color1", (Serializable) mTvColor);
//        intent.putExtra("location1", (Serializable) mTvLocation);
//        intent.putExtra("phone1", (Serializable) mTvPhone);
//        intent.putExtra("about1", (Serializable) mTvAbout);
//        startActivity(intent);
    }

    override fun onPaymentError(i: Int, s: String) {
        paytext!!.text = "Failed and cause is :$s"
    }
}