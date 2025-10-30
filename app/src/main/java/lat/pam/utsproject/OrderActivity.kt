package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    private lateinit var foodNameTextView: TextView
    private lateinit var servingsEditText: EditText
    private lateinit  var customerNameEditText: EditText
    private lateinit var notesEditText: EditText
    private lateinit var orderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodName = intent.getStringExtra("foodName")
        var foodNameTextView = findViewById<TextView>(R.id.etFoodName)

        if (foodName != null) {
            foodNameTextView.text = foodName
        } else {
            foodNameTextView.text = "No food selected"
        }


        foodNameTextView = findViewById(R.id.etFoodName)
        servingsEditText = findViewById(R.id.etServings)
        customerNameEditText = findViewById(R.id.etName)
        notesEditText = findViewById(R.id.etNotes)
        orderButton = findViewById(R.id.btnOrder)

        orderButton.setOnClickListener {
            val foodName = foodNameTextView.text.toString().trim()
            val servings = servingsEditText.text.toString().trim().toIntOrNull()
            val customerName = customerNameEditText.text.toString().trim()
            val notes = notesEditText.text.toString().trim()

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("foodName", foodName)
            intent.putExtra("servings", servings)
            intent.putExtra("customerName", customerName)
            intent.putExtra("notes", notes)

            startActivity(intent)
        }

    }
}