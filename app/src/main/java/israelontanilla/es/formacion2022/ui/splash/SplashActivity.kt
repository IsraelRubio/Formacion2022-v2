package israelontanilla.es.formacion2022.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.lifecycleScope
import israelontanilla.es.formacion2022.common.BaseActivity
import israelontanilla.es.formacion2022.databinding.ActivitySplashBinding
import israelontanilla.es.formacion2022.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}