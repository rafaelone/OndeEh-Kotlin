package br.com.rafaelsergio.ondeeh.ui.pesquisa

import android.os.Bundle
import android.widget.Toast
import br.com.rafaelsergio.ondeeh.R
import br.com.rafaelsergio.ondeeh.base.BaseActivity
import br.com.rafaelsergio.ondeeh.model.Endereco
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity :BaseActivity<PesquisaPresenter>(), PesquisaView {
    override fun instantiatePresenter(): PesquisaPresenter {
        return PesquisaPresenter(this)
    }

    override fun atualizaEndereco(endereco: Endereco) {
        tvLogradouro.text = endereco.logradouro
        tvBairro.text = endereco.bairro
        tvLocalidade.text = endereco.localidade
        tvUF.text = endereco.uf
     Toast.makeText(this, endereco.logradouro, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {

    }

    override fun showLoading() {
        Toast.makeText(this, "Carregando....", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
       // presenter.loadPosts("05175250")
        buscarCep()
    }

    private fun buscarCep(){
        btPesquisar.setOnClickListener {
            presenter.loadPosts(etCEP.text.toString())
        }
    }
}
