package com.quizolog.kvizologapp.pitanje_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.quizolog.kvizologapp.MainActivity;
import com.quizolog.kvizologapp.R;
import com.quizolog.kvizologapp.data.database.KvizologDatabase;
import com.quizolog.kvizologapp.data.model.Igra_ima_Pitanje;
import com.quizolog.kvizologapp.data.model.Pitanje;

import java.lang.reflect.Field;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.ViewHolder> {
    //Make a list of items for recycler view
    private List<Igra_ima_Pitanje> items;

    public interface OnItemClickListener {
        void onItemClick(Igra_ima_Pitanje item);
    }

    private com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.OnItemClickListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRedniBroj;
        public TextView tvTipPitanja;
        public TextView tvTekstPitanja;
        public TextView tvTacanOdgovor;
        public TextView tvKorisnikovOdgovor;
        public ImageView ivSlikaPitanja;
        public ImageView ivSlikaTacnostiOdgovora;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvRedniBroj = v.findViewById(R.id.tv_redni_broj);
            tvTipPitanja = v.findViewById(R.id.tv_tip_pitanja);
            tvTekstPitanja = v.findViewById(R.id.tv_tekst_pitanja);
            tvTacanOdgovor = v.findViewById(R.id.tv_tacan_odgovor);
            tvKorisnikovOdgovor = v.findViewById(R.id.tv_korisnikov_odgovor);
            ivSlikaPitanja = v.findViewById(R.id.iv_question_image);
            ivSlikaTacnostiOdgovora = v.findViewById(R.id.iv_correctness_image);
        }

    }

    public Adapter(List<Igra_ima_Pitanje> items, com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // creating a new view-a
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.pitanje_card, parent, false);
        com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.ViewHolder vh = new com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.ViewHolder(v);
        return vh;
    }

    // setting content inside view-a (invoked by the layout manager)
    @Override
    public void onBindViewHolder(com.quizolog.kvizologapp.pitanje_recyclerview.Adapter.ViewHolder holder, final int position) {
        final Igra_ima_Pitanje item = items.get(position);

        //Get pitanje data from the database
        KvizologDatabase database = KvizologDatabase.getInstance();
        Pitanje pitanje = database.pitanjeDAO().getById(item.getIdPitanje());
        //Set data of the question card...
        holder.tvRedniBroj.setText(Integer.toString(position+1)+". ");
        switch(pitanje.getTipPitanja()){
            case 0:
                holder.tvTipPitanja.setText(R.string.tip_pitanja_glavni_grad);
                holder.tvTekstPitanja.setText(R.string.tekst_pitanja_glavni_grad);
                if("en".equals(MainActivity.lang))
                    holder.tvTekstPitanja.setText(holder.tvTekstPitanja.getText().toString() + " " + pitanje.getTekstPitanjaEngleski()+" ?");
                else
                    holder.tvTekstPitanja.setText(holder.tvTekstPitanja.getText().toString() + " " + pitanje.getTekstPitanjaSrpski()+" ?");
                break;
            case 1:
                holder.tvTipPitanja.setText(R.string.tip_pitanja_zastava);
                holder.tvTekstPitanja.setText(R.string.tekst_pitanja_zastava);
                break;
            case 2:
                holder.tvTipPitanja.setText(R.string.tip_pitanja_susjedne_drzave);
                holder.tvTekstPitanja.setText(R.string.tekst_pitanja_susjedne_drzave);
                if("en".equals(MainActivity.lang))
                    holder.tvTekstPitanja.setText(holder.tvTekstPitanja.getText().toString() + " " + pitanje.getTekstPitanjaEngleski()+" ?");
                else
                    holder.tvTekstPitanja.setText(holder.tvTekstPitanja.getText().toString() + " " + pitanje.getTekstPitanjaSrpski()+" ?");
                break;
            case 3:
                holder.tvTipPitanja.setText(R.string.tip_pitanja_znamenitost);
                holder.tvTekstPitanja.setText(R.string.tekst_pitanja_znamenitost);
                break;
        }
        //Set correct answer text
        if("en".equals(MainActivity.lang))
            if(pitanje.getTipPitanja()==1)
                holder.tvTacanOdgovor.setText(holder.tvTacanOdgovor.getText().toString()+" "+pitanje.getOdgovorBr1Engleski());
            else
                holder.tvTacanOdgovor.setText(holder.tvTacanOdgovor.getText().toString()+" "+pitanje.getTacniOdgovoriEngleski().replace(":"," "));
        else
            if(pitanje.getTipPitanja()==1)
                holder.tvTacanOdgovor.setText(holder.tvTacanOdgovor.getText().toString()+" "+pitanje.getTekstPitanjaSrpski());
            else
                holder.tvTacanOdgovor.setText(holder.tvTacanOdgovor.getText().toString()+" "+pitanje.getTacniOdgovoriSrpski().replace(":"," "));
        //Set users answer text
        if(item.getKorisnikovOdgovor().isEmpty())
            //If question is skipped write a message
            holder.tvKorisnikovOdgovor.setText(holder.tvKorisnikovOdgovor.getText().toString() + " " + R.string.tekst_neodgovoreno_pitanje);
        else
            holder.tvKorisnikovOdgovor.setText(holder.tvKorisnikovOdgovor.getText().toString() + " " +item.getKorisnikovOdgovor());
        if(!item.isJeTacnoOdgovoreno())
            holder.ivSlikaTacnostiOdgovora.setImageResource(R.drawable.ic_baseline_cancel_24);
        //Set image of the question
        if(pitanje.getTipPitanja() == 1 || pitanje.getTipPitanja() == 3 ){
            holder.ivSlikaPitanja.setVisibility(View.VISIBLE);
            Class res = R.drawable.class;
            Field field = null;
            int drawableId = 0;
            try {
                field = res.getField(pitanje.getSlika());
                drawableId = field.getInt(field);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }catch (IllegalAccessException exc){
                exc.printStackTrace();
            }
            holder.ivSlikaPitanja.setImageResource(drawableId);
        }
        else
            holder.ivSlikaPitanja.setVisibility(View.GONE);
        //Set correct answer question card
        //TO-DO


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
