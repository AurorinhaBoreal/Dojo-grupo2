package com.dojo.account.contas;

import java.util.Date;
import com.dojo.account.modelo.Conta;

public class ContaPoupanca extends Conta {
    private final int minDepositoInicial = 50;
    private final double taxaRendimento = 0.05;
    private double depositoInicial;
    private Date dataAbertura;
    private double saldo = 0;


    
    public ContaPoupanca(int idConta, double depositoInicial, Date dataAbertura) {
        super(idConta);
        this.depositoInicial = depositoInicial;
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String consultarSaldo() {
        return "Seu saldo é "+saldo;
    }

    @Override
    public void saque(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");            
        } if(this.saldo - valor < 0){
            throw new IllegalArgumentException("Saldo insuficiente");          
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

    @Override
    public void deposito(double valor) {
        valor = 50;
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");    
        }
        this.saldo += valor;
        System.out.println("Depósito efetuado com Sucesso!!");
    }

    @Override
    public void transferir(double valor, Conta conta) {

    }
    @Override
    public String toString() {
        return "Conta Poupança | ID: " + getIdConta();
    }

    public void rendimento() {
        if (dataAbertura != null){
            Date dataAtual = new Date();
            Long diferenca = dataAtual.getTime() - dataAbertura.getTime();
            Long dias = diferenca / (1000 * 60 * 60 * 24);
            this.saldo += this.saldo * taxaRendimento * dias;
        }
    }
}

