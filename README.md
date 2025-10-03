# 🎯 ENTREGA DO DESAFIO SIMPLES PROPOSTO PARA COMPROVAÇÃO DE ORIENTAÇÃO A OBJETOS

## Criando um Banco Digital com Java e Orientação a Objetos

**Desafio Original:** Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte cenário:
"Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição)."

## 🚀 Implementação da Hierarquia de Clientes

**Desafio Adicional:** Implementação de uma hierarquia de clientes com regras de negócio específicas para cada tipo, demonstrando os conceitos de **Herança**, **Polimorfismo** e **Classes Abstratas**.

### 📋 Estrutura Implementada

#### 1. **Cliente (Classe Abstrata)**

- **Transformação:** Convertida de classe concreta para classe abstrata
- **Funcionalidades:**
  - Validação de CPF usando algoritmo oficial da Receita Federal
  - Atributos base: CPF e nome
  - Métodos abstratos para regras de negócio específicas

```java
public abstract class Cliente {
    private final String cpf;
    private String nome;

    // Métodos abstratos
    public abstract double calcularLimiteCredito();
    public abstract double calcularTaxaJuros();
    public abstract boolean temDireitoDesconto();
    public abstract String getTipoCliente();
}
```

#### 2. **PessoaFisica extends Cliente**

- **Atributos específicos:**
  - RG, data de nascimento, profissão
- **Regras de negócio:**
  - **Limite de crédito:** R$ 1.000 a R$ 5.000 (baseado na profissão)
  - **Taxa de juros:** 2,5% ao mês
  - **Desconto:** Sempre tem direito
  - **Profissões premium:** Médico, Advogado, Engenheiro (R$ 5.000)

#### 3. **PessoaJuridica extends Cliente**

- **Atributos específicos:**
  - CNPJ, razão social, nome fantasia, ramo de atividade, número de funcionários
- **Regras de negócio:**
  - **Limite de crédito:** R$ 1.000 por funcionário + ajuste por ramo (até +50%)
  - **Taxa de juros:** 3,5% ao mês
  - **Desconto:** Apenas com 50+ funcionários
  - **Ramos premium:** Tecnologia e Finanças (+50%)

### 🎯 Conceitos de OO Demonstrados

#### **Herança**

- `PessoaFisica` e `PessoaJuridica` herdam atributos e comportamentos de `Cliente`
- Reutilização de código e validação de CPF
- Extensão de funcionalidades específicas para cada tipo

#### **Polimorfismo**

- Métodos abstratos implementados de forma diferente em cada classe filha
- Mesma interface, comportamentos específicos
- Uso de `@Override` para sobrescrever métodos

#### **Classes Abstratas**

- `Cliente` não pode ser instanciada diretamente
- Define contrato através de métodos abstratos
- Força implementação de regras de negócio específicas

### 📊 Exemplo de Uso

```java
PessoaFisica clientePF = new PessoaFisica("554.724.390-60", "João Silva",
                                         "12.345.678-9", "15/03/1985", "Engenheiro");

PessoaJuridica clientePJ = new PessoaJuridica("111.444.777-35", "Maria Santos",
                                             "12.345.678/0001-90", "Tech Solutions LTDA",
                                             "TechSol", "Tecnologia", 25);

System.out.println("PF - Limite: R$ " + clientePF.calcularLimiteCredito());
System.out.println("PJ - Limite: R$ " + clientePJ.calcularLimiteCredito());
```

### 🏗️ Arquitetura do Sistema

```
Cliente (abstract)
├── PessoaFisica
│   ├── RG, Data Nascimento, Profissão
│   ├── Limite: R$ 1.000 - R$ 5.000
│   ├── Taxa: 2,5% a.m.
│   └── Desconto: Sempre
└── PessoaJuridica
    ├── CNPJ, Razão Social, Nome Fantasia
    ├── Limite: R$ 1.000/funcionário + ajuste
    ├── Taxa: 3,5% a.m.
    └── Desconto: 50+ funcionários
```

### 🧪 Validação e Testes

- **Validação de CPF:** Algoritmo oficial da Receita Federal
- **Testes de regras:** Demonstração de diferentes cenários
- **Polimorfismo:** Uso de referências da classe pai
- **Encapsulamento:** Atributos privados com getters/setters

### 📚 Conceitos Fundamentais de OO

#### **Abstração**

Habilidade de concentrar-se nos aspectos essenciais de um domínio, ignorando características menos importantes ou acidentais. Nesse contexto, objetos são abstrações de entidades existentes no domínio em questão.

#### **Encapsulamento**

Encapsular significa esconder a implementação dos objetos, criando assim interfaces de uso mais concisas e fáceis de usar/entender. O encapsulamento favorece principalmente dois aspectos de um sistema: a manutenção e a evolução.

#### **Herança**

Permite que você defina uma classe filha que reutiliza (herda), estende ou modifica o comportamento de uma classe pai. A classe cujos membros são herdados é chamada de classe base. A classe que herda os membros da classe base é chamada de classe derivada.

#### **Polimorfismo**

Capacidade de um objeto poder ser referenciado de várias formas, ou seja, é capacidade de tratar objetos criados a partir das classes específicas como objetos de uma classe genérica. Cuidado, polimorfismo não quer dizer que o objeto fica se transformando, muito pelo contrário, um objeto nasce de um tipo e morre daquele tipo, o que pode mudar é a maneira como nos referimos a ele.

---

## 🎓 Sobre Este Projeto

Este projeto faz parte de um **desafio simples do início da trilha/formação de 72h de Java** da Digital Innovation One (DIO), demonstrando a aplicação prática dos conceitos fundamentais de Orientação a Objetos em Java.

### 🛠️ Tecnologias Utilizadas

- **Java 8+**
- **Conceitos de OO:** Herança, Polimorfismo, Classes Abstratas
- **Validação:** Algoritmo oficial de CPF
- **Documentação:** JavaDoc com formatação HTML

### 📁 Estrutura do Projeto

```
src/
├── Cliente.java          # Classe abstrata base
├── PessoaFisica.java     # Implementação para pessoa física
├── PessoaJuridica.java   # Implementação para pessoa jurídica
├── Conta.java            # Classe base para contas
├── ContaCorrente.java    # Conta corrente
├── ContaPoupanca.java    # Conta poupança
├── IConta.java           # Interface para contas
├── Banco.java            # Classe do banco
└── Main.java             # Classe principal com exemplos
```

### 🚀 Como Executar

```bash
# Compilar
javac -d bin src/*.java

# Executar
java -cp bin Main
```

---

## ✅ ENTREGA CONCLUÍDA

**Status:** ✅ **DESAFIO ENTREGUE COM SUCESSO**

Este projeto demonstra a aplicação prática dos conceitos fundamentais de Orientação a Objetos em Java, implementando uma hierarquia de clientes com regras de negócio específicas para cada tipo.

**Desenvolvido como parte do bootcamp Java da DIO - Formação 76h** 🚀
