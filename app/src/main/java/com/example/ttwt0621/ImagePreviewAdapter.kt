package com.example.ttwt0621

import android.content.Context

/*
class ImagePreviewAdapter @Inject constructor(@ApplicationContext private val context: Context, private val list : ArrayList<ImagePreview>){

    private var _binding: FragmentTimerBinding? = null

    override fun  onCreateViewHolder(parent: ViewGroup, viewType : Int) : ViewHolder {
                val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.timer_view_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return ViewHolder(view)
    }

   override fun onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteInfo note = list.get(position);
        holder.textCourse.setText(note.getCourse().getTitle());
        holder.textTitle.setText(note.getTitle());
        holder.currentPosition = position;
    }
}
*/
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textTitle;
        public final TextView textCourse;
        public int currentPosition;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION, currentPosition);
                    context.startActivity(intent);
                }
            });
            textCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            textTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
 */