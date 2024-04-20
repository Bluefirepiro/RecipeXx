import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipexx.FamilyMember
import com.example.recipexx.R

class FamilyMemberAdapter(private val familyMembers: List<FamilyMember>) :
    RecyclerView.Adapter<FamilyMemberAdapter.FamilyMemberViewHolder>() {

    private var itemClickListener: ((FamilyMember) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyMemberViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_family_member, parent, false)
        return FamilyMemberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FamilyMemberViewHolder, position: Int) {
        val familyMember = familyMembers[position]
        holder.bind(familyMember)
    }

    override fun getItemCount(): Int {
        return familyMembers.size
    }

    inner class FamilyMemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewFamilyMember)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.invoke(familyMembers[position])
                }
            }
        }

        fun bind(familyMember: FamilyMember) {
            nameTextView.text = familyMember.name
        }
    }

    // Function to set click listener for each family member item
    fun setOnItemClickListener(listener: (FamilyMember) -> Unit) {
        itemClickListener = listener
    }
}
