package technology.digital.saksham.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paytm.pgsdk.PaytmOrder
import com.paytm.pgsdk.PaytmPGService
import com.paytm.pgsdk.PaytmPaymentTransactionCallback
import technology.digital.saksham.R
import kotlin.random.Random


class PaymentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        var random = Random.nextInt(999999)
        val Service = PaytmPGService.getProductionService()

        //        `$paramList`.get("MID") = PAYTM_MERCHANT_MID
//        `$paramList`.get("ORDER_ID") = `$ORDER_ID`
//        `$paramList`.get("CUST_ID") = `$CUST_ID`
//        `$paramList`.get("INDUSTRY_TYPE_ID") = `$INDUSTRY_TYPE_ID`
//        `$paramList`.get("CHANNEL_ID") = `$CHANNEL_ID`
//        `$paramList`.get("TXN_AMOUNT") = `$TXN_AMOUNT`
//        `$paramList`.get("WEBSITE") = PAYTM_MERCHANT_WEBSITE
//
//
//        `$paramList`.get("CALLBACK_URL") =
//            "https://www.sakshamdigitaltechnology.com/payment-response.php"
//        `$paramList`.get("MSISDN") = `$MSISDN` //Mobile number of customer
//
//        `$paramList`.get("EMAIL") = `$EMAIL` //Email ID of customer
//
//        `$paramList`.get("VERIFIED_BY") = "EMAIL" //
//
//        `$paramList`.get("IS_USER_VERIFIED") = "YES" //


        val paramMap = HashMap<String, String>()
        paramMap.put("MID", "Saksha79721267440187")
        paramMap.put("ORDER_ID", random.toString())
        paramMap.put("CUST_ID", random.toString())
        paramMap.put("MOBILE_NO", "7042143686")
        paramMap.put("EMAIL", "raj.shiladitya@gmail.com")
        paramMap.put("CHANNEL_ID", "WAP")
        paramMap.put("TXN_AMOUNT", "1")
        paramMap.put("WEBSITE", "Saksha")
        paramMap.put("INDUSTRY_TYPE_ID", "Retail109")
        paramMap.put(
            "CALLBACK_URL",
            "https://www.sakshamdigitaltechnology.com/payment-response.php"
        )
        paramMap.put(
            "CHECKSUMHASH",
            "w2QDRMgp1234567JEAPCIOmNgQvsi+BhpqijfM9KvFfRiPmGSt3Ddzw+oTaGCLneJwxFFq5mqTMwJXdQE2EzK4px2xruDqKZjHupz9yXev4="
        )
        val Order = PaytmOrder(paramMap)
        Service.initialize(Order, null)

        Service.startPaymentTransaction(this, true, true, object : PaytmPaymentTransactionCallback {
            /*Call Backs*/
            override fun someUIErrorOccurred(inErrorMessage: String) {
                Toast.makeText(applicationContext, "UI Error " + inErrorMessage, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onTransactionResponse(inResponse: Bundle) {

                Toast.makeText(
                    applicationContext,
                    "Payment Transaction response " + inResponse.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun networkNotAvailable() {

                Toast.makeText(
                    applicationContext,
                    "Network connection error: Check your internet connectivity",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun clientAuthenticationFailed(inErrorMessage: String) {
                Toast.makeText(
                    applicationContext,
                    "Authentication failed: Server error" + inErrorMessage.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onErrorLoadingWebPage(
                iniErrorCode: Int,
                inErrorMessage: String,
                inFailingUrl: String
            ) {
                Toast.makeText(
                    applicationContext,
                    "Unable to load webpage " + inErrorMessage.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onBackPressedCancelTransaction() {}
            override fun onTransactionCancel(
                inErrorMessage: String,
                inResponse: Bundle
            ) {

                Toast.makeText(applicationContext, "Transaction cancelled", Toast.LENGTH_LONG)
                    .show()
            }
        })

    }
}