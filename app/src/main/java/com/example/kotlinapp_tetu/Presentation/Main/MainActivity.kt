package com.example.kotlinapp_tetu.Presentation.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp_tetu.Presentation.Main.Adapter.PokemonAdapter
import com.example.kotlinapp_tetu.Presentation.Main.Interface.RetrofitService
import com.example.kotlinapp_tetu.Data.Local.Model.Pokemon
import com.example.kotlinapp_tetu.Domain.Entity.User
import com.example.kotlinapp_tetu.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_user.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : PokemonAdapter

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.LoginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> getAllPokeList()
                is LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("User email address or Password Incorrect")
                        .setPositiveButton("OK") {dialog, which-> dialog.dismiss()}
                        .show()
                }
            }
        })

        Login_Button.setOnClickListener{
            mainViewModel.onClickedLogin(Login_Edit.toString().trim(), Password_Edit.toString())
        }

        Create_Account_Button.setOnClickListener{
            add_user.goto()
            AddNewUser(User.email, User.password)
            mainViewModel.onClickedLogin(AddEmail_Edit.toString().trim(), AddPassword_Edit.toString())
        }

        recyclerPokeList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerPokeList.layoutManager = layoutManager


    }

    private fun getAllPokeList() {

        mService.getPokemonList().enqueue(object : Callback<MutableList<Pokemon>> {
            override fun onFailure(call: Call<MutableList<Pokemon>>, t: Throwable) {
               System.out.println("ERROR")
            }

            override fun onResponse(
                call: Call<MutableList<Pokemon>>,
                response: Response<MutableList<Pokemon>>
            ) {
               adapter = PokemonAdapter(
                   baseContext,
                   response.body() as MutableList<Pokemon>
               )
               adapter.notifyDataSetChanged()
               recyclerPokeList.adapter = adapter


            }

        })
    }

    private fun AddNewUser(email: String, password: String){
        val email = AddEmail.text.toString()
        val password = AddPassword.text.toString()


    }

}
