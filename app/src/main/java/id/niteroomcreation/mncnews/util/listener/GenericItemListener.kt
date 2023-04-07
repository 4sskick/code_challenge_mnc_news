package id.niteroomcreation.mncnews.util.listener

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
interface GenericItemListener<M, V : Any?> {
    fun onItemViewClicked(item: M)
}