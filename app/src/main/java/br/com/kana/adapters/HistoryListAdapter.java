package br.com.kana.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.uol.ps.core.api.vo.TransactionDataVO;
import br.com.uol.ps.core.util.PagSegUtil;
import br.com.uol.ps.wallet.R;

/**
 * Created by everton on 25/04/14.
 */
public class HistoryListAdapter extends BindingAdapter<TransactionDataVO> {


    private final View.OnClickListener onClickListener;
    private final boolean cameFromPayment;

    private List<TransactionDataVO> transactions = new ArrayList<TransactionDataVO>();

    public HistoryListAdapter(Context context, List<TransactionDataVO> transactions, View.OnClickListener onClickListener, boolean cameFromPayment) {
        super(context);
        this.transactions = transactions;
        this.onClickListener = onClickListener;
        this.cameFromPayment = cameFromPayment;
    }

    public void setTransactions(List<TransactionDataVO> transactions) {
        this.transactions = transactions;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.transactions.size();
    }

    @Override
    public TransactionDataVO getItem(int position) {
        return transactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View v = inflater.inflate(R.layout.history_list_item, container, false);
        final ViewHolder holder = new ViewHolder(v, position);
        return v;
    }

    @Override
    public void bindView(TransactionDataVO item, int position, View view) {
        final ViewHolder holder = (ViewHolder) view.getTag();

        holder.item = item;

        holder.colorStatus.setBackgroundColor(item.getStatus().getColor(getContext()));
        holder.partnerName.setText(item.getSellerIdentification());
        holder.date.setText(PagSegUtil.formatDateHistory(item.getCreationDate().getDateTime()));
        holder.amount.setText(PagSegUtil.formatNumberToCurrency(item.getOriginalAmount()));

    }





    /*--------------------
         VIEW HOLDER
     --------------------- */

    public class ViewHolder {
        private int position;
        View colorStatus;

        ViewGroup listItem;
        TextView partnerName;
        TextView date;
        TextView amount;

        TransactionDataVO item;

        public ViewHolder(View v, int position) {

            this.position = position;

            listItem = (ViewGroup) v.findViewById(R.id.list_item);
            colorStatus = v.findViewById(R.id.color_status);
            partnerName = (TextView) v.findViewById(R.id.partner_name);
            date = (TextView) v.findViewById(R.id.date);
            amount = (TextView) v.findViewById(R.id.amount);

            v.setTag(this);

            listItem.setOnClickListener(onClickListener);
        }

        public TransactionDataVO getItem() {
            return item;
        }
    }
}
