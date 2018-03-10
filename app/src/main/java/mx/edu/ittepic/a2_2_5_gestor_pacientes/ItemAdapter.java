package mx.edu.ittepic.a2_2_5_gestor_pacientes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 * Define RecyclerView.Adapter y RecyclerView.ViewHolder
 * Establece listener para los componentes
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Item> list;
    private AlertDialog dialog;

    public ItemAdapter(Activity activity, ArrayList<Item> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Referencia para almacenar el contexto
        Context context;
        context = parent.getContext();

        // Referencia para el inflater
        LayoutInflater nuevo;
        nuevo = LayoutInflater.from(context);

        View itemView = nuevo.inflate(R.layout.item_list,parent,false);


        return new MyViewHolder(itemView);
    }

    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Item item = list.get(position);

        holder.lastname.setText(item.getLastname());
        holder.firstname.setText( item.getFirstname());
        holder.middlename.setText( item.getMiddlename());
        holder.contact.setText(item.getContact());
        holder.fecha.setText(item.getFecha());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit,null);

                final EditText input_lastname = (EditText) view1.findViewById(R.id.Lastname);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.Firstname);
                final EditText input_middlename = (EditText) view1.findViewById(R.id.MiddleName);
                final EditText input_contact = (EditText) view1.findViewById(R.id.Contact);
                final EditText input_fecha = (EditText) view1.findViewById(R.id.Fecha);
                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Edit Records").setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final Item _items = functions.getSingleItem(id);
                input_lastname.setText(_items.getLastname());
                input_firstname.setText(_items.getFirstname());
                input_middlename.setText(_items.getMiddlename());
                input_contact.setText(_items.getContact());
                input_fecha.setText(_items.getFecha());

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String lastname = input_lastname.getText().toString();
                        String firstname = input_firstname.getText().toString();
                        String middlename = input_middlename.getText().toString();
                        String contact = input_contact.getText().toString();
                        String fecha = input_fecha.getText().toString();

                        _items.setLastname(lastname);
                        _items.setFirstname(firstname);
                        _items.setMiddlename(middlename);
                        _items.setContact(contact);
                        _items.setFecha(fecha);

                        functions.Update(_items);

                        Toast.makeText(activity, lastname + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity)activity).fetchRecords();
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lastname;
        TextView firstname;
        TextView middlename;
        TextView contact;
        TextView fecha;

        TextView btnEdit;
        TextView btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            lastname = itemView.findViewById(R.id.Lastname);
            firstname = itemView.findViewById(R.id.firstname);
            middlename = itemView.findViewById(R.id.middlename);
            contact = itemView.findViewById(R.id.contact);
            fecha = itemView.findViewById(R.id.Fecha);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
