package br.com.rafaelsergio.ondeeh.ui.pesquisa

import android.support.annotation.StringRes
import br.com.rafaelsergio.ondeeh.base.BaseView
import br.com.rafaelsergio.ondeeh.model.Endereco

interface PesquisaView: BaseView {


    fun atualizaEndereco(endereco: Endereco)

    fun showError(error:String)

    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}