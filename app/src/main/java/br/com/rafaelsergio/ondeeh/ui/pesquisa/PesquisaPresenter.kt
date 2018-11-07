package br.com.rafaelsergio.ondeeh.ui.pesquisa

import br.com.rafaelsergio.ondeeh.R
import br.com.rafaelsergio.ondeeh.base.BasePresenter
import br.com.rafaelsergio.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(pesquisaView: PesquisaView):
        BasePresenter<PesquisaView>(pesquisaView){

    @Inject

    lateinit var enderecoAPI: EnderecoAPI
    private var subscription: Disposable ? = null

    override fun onViewCreated() {

    }

    fun loadPosts(cep: String) {
        view.showLoading()
        subscription = enderecoAPI
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { endereco -> view.atualizaEndereco(endereco) },
                        { view.showError(R.string.unknown_error) }
                )
    }


    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}