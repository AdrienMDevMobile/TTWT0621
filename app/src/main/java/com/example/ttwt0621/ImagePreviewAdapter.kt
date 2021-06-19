package com.example.ttwt0621

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttwt0621.data.ImagePreview
import kotlin.properties.Delegates


class ImagePreviewAdapter(private val list : ArrayList<ImagePreview>)
    : RecyclerView.Adapter<ImagePreviewAdapter.ViewHolder>(){
    //private val context: Context,
    private val layoutInflater: LayoutInflater? = null

    override fun  onCreateViewHolder(parent: ViewGroup, viewType : Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePreview = list.get(position)
        holder.textImagePreview.setText(imagePreview.tags)
        holder.currentPosition = position
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        public val textImagePreview : TextView
        public var currentPosition : Int =-1

        init{
            /*
            itemView.setOnClickListener(new View.OnClickListener(){

                override fun onClick(View v) {
                    Intent intent = new Intent(context, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION, currentPosition);
                    context.startActivity(intent);
                }
            })*/
            textImagePreview = itemView.findViewById(R.id.tvImagePreview);
        }
    }
}

/*


public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>{

    private final Context context;
    private final List<NoteInfo> notes;
    private final LayoutInflater layoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteInfo note = notes.get(position);
        holder.textCourse.setText(note.getCourse().getTitle());
        holder.textTitle.setText(note.getTitle());
        holder.currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


}
 */