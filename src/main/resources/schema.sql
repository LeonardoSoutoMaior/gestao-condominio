CREATE TABLE IF NOT EXISTS condominio(
    id_condominio  UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    endereco VARCHAR(200),
    quantidade_de_unidades INT,
    data_de_criacao DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS unidade(
    id_unidade UUID DEFAULT RANDOM_UUID(),
    numero INT,
    andar VARCHAR(30),
    id_condominio UUID NOT NULL,
    PRIMARY KEY (id_unidade, id_condominio),
    FOREIGN KEY (id_condominio) REFERENCES condominio (id_condominio)
);

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(200)
    email VARCHAR(100)
    senha VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tarefa (
    id_tarefa UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(600),
    data_inicio DATE DEFAULT CURRENT_DATE,
    data_termino DATE,
    prioridade VARCHAR(45) CHECK (prioridade IN ('alta', 'media', 'baixa')),
    status VARCHAR(45) CHECK (status IN ('pendente', 'em andamento', 'concluido')),
    id_condominio UUID NOT NULL,
    id_usuario UUID NOT NULL,
    FOREIGN KEY (id_condominio) REFERENCES condominio(id_condominio),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE IF NOT EXISTS ocorrencia(
    id_ocorrencia UUID DEFAULT RANDOM_UUID() PRIMARY KEY
    nome VARCHAR(50) NOT NULL
    descricao VARCHAR(200)
    data_inicio DATE DEFAULT CURRENT_DATE
    data_termino DATE
    status VARCHAR(45) CHECK (status IN ('pendente', 'em andamento', 'concluido'))
    id_condominio UUID NOT NULL
    id_unidade UUID NOT NULL
    unidade_condominio_id UUID NOT NULL
    PRIMARY KEY(id_ocorrencia, id_condominio, id_unidade, unidade_condominio_id)
    FOREIGN KEY(id_condominio) REFERENCES condominio(id_condominio)
    FOREIGN KEY(id_unidade, unidade_condominio_id) REFERENCES unidade(id_unidade, id_condominio)
)

CREATE TABLE IF NOT EXISTS documento(
    id_documento UUID RANDOM_UUID() PRIMARY KEY
    nome VARCHAR(40)
    url VARCHAR(200)
    data_upload DATE DEFAULT CURRENT_DATE
    id_condominio UUID NOT NULL
    FOREIGN KEY(id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS receita(
    id_receita UUID RANDOM_UUID() PRIMARY KEY
    descricao VARCHAR(40)
    valor DECIMAL(10, 2)
    data_entrada DATE DEFAULT CURRENT_DATE
    id_condominio UUID NOT NULL
    FOREIGN KEY(id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS despesa(
    id_despesa UUID RANDOM_UUID() PRIMARY KEY
    descricao VARCHAR(40)
    valor DECIMAL(10, 2)
    data_entrada DATE DEFAULT CURRENT_DATE
    id_condominio UUID NOT NULL
    FOREIGN KEY(id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS reuniao(
    id_reuniao UUID RANDOM_UUID() PRIMARY KEY
    data DATE
    hora TIME
    local_reuniao VARCHAR(100)
    pauta VARCHAR(50)
    id_condominio UUID NOT NULL
    FOREIGN KEY(id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS fornecedor(
    id_fornecedor UUID RANDOM_UUID() PRIMARY KEY
    nome VARCHAR(100)
    servico_prestado VARCHAR(50)
    contato VARCHAR(15)
    avaliacao INT(10)
    id_condominio UUID NOT NULL
    FOREIGN KEY (id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS equipamento(
    id_equipamento UUID RANDOM_UUID() PRIMARY KEY
    nome VARCHAR(50)
    detalhes_tecnicos VARCHAR(100)
    id_condominio UUID NOT NULL
    FOREIGN KEY (id_condominio) REFERENCES condominio(id_condominio)
)

CREATE TABLE IF NOT EXISTS manutencao(
    id_manutencao UUID RANDOM_UUID() PRIMARY KEY
    descricao VARCHAR(100)
    data_agendamento DATE
    data_execucao DATE
    custo DECIMAL(10, 2)
    id_equipamento UUID NOT NULL
    id_fornecedor UUID NOT NULL
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento)
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor)
)

CREATE TABLE IF NOT EXISTS mensagem(
    id_mensagem UUID RANDOM_UUID() PRIMARY KEY
    conteudo VARCHAR(200)
    data_salva DATE DEFAULT CURRENT_DATE
)

CREATE TABLE IF NOT EXISTS relatorio(
    id_relatorio UUID RANDOM_UUID() PRIMARY KEY
    tipo VARCHAR(50)
    data_geracao DATE DEFAULT CURRENT_DATE
    id_condominio UUID NOT NULL
    FOREIGN KEY (id_condominio) REFERENCES condominio(id_condominio)
)