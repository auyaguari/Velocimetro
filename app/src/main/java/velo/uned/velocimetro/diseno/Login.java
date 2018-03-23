package velo.uned.velocimetro.diseno;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import velo.uned.velocimetro.databinding.ActivityLoginBinding;
import velo.uned.velocimetro.main.ActividadPrincipal;
import velo.uned.velocimetro.modelo.User;

import velo.uned.velocimetro.servicios.UsersServicio;
import velo.uned.velocimetro.R;

public class Login extends AppCompatActivity {
    User user;
    //TextView btnreg;
    UsersServicio usersServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityActividadPrincipalBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_actividad_principal);
        //med = new Medicion();
        //binding.setDbMedicion(data);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        user =new User();
        usersServicio=new UsersServicio(this);
        binding.setDbuser(user);
        //btnreg=findViewById(R.id.btnRegistrar);
        //btnreg.setOnClickListener(new View.OnClickListener() {

        //    @Override
        //    public void onClick(View view) {
        //        Intent intentReg = new Intent(Login.this,Registro.class);
        //        Login.this.startActivity(intentReg);
        //    }
        //});
    }
//Ingresar Al sistema
    public void ingresar(View view) {
        if (usersServicio.getUser(user)){
                Toast.makeText(this, "Bienvenido!", Toast.LENGTH_SHORT).show();
                Intent intentIng = new Intent(Login.this, ActividadPrincipal.class);
                Login.this.startActivity(intentIng);
        } else {
            Toast.makeText(this, "Logeo Incorrecto!", Toast.LENGTH_SHORT).show();
        }
    }
}
