# Gestão de Condomínios

## Descrição

Este é um sistema de gestão de condomínios desenvolvido em Java com Spring, projetado para auxiliar na administração de diferentes aspectos de um condomínio. A aplicação oferece funcionalidades para gerenciar unidades, usuários, tarefas, ocorrências, documentos, receitas, despesas, reuniões, fornecedores, equipamentos, manutenções, mensagens e relatórios.

## Funcionalidades

### Condomínios
- **Cadastro e Gerenciamento de Condomínios:** Possibilidade de cadastrar novos condomínios, atualizar informações, e deletar condomínios existentes.
- **Unidades:** Gerenciamento de unidades dentro de cada condomínio, incluindo a verificação de duplicidade de unidades (andar e número).

### Usuários
- **Cadastro de Usuários:** Criação de usuários com nome, email e senha.
- **Autenticação Simples:** Verificação de email único para garantir que não haja duplicidade de usuários.

### Tarefas
- **Gerenciamento de Tarefas:** Cadastro de tarefas com prioridade, status e descrição. As tarefas são vinculadas a um condomínio e a um usuário responsável.

### Ocorrências
- **Registro de Ocorrências:** Possibilidade de registrar ocorrências dentro do condomínio, associando-as a uma unidade específica.

### Documentos
- **Upload e Gerenciamento de Documentos:** Armazenamento de documentos relacionados ao condomínio, com suporte para upload de PDFs.

### Receitas e Despesas
- **Registro de Receitas e Despesas:** Gerenciamento de receitas e despesas associadas ao condomínio.
- **Cálculo de Lucro ou Prejuízo:** Possibilidade de calcular o lucro ou prejuízo total do condomínio e filtrar por período (semanal, mensal e anual).

### Reuniões
- **Agendamento de Reuniões:** Agendamento de reuniões, incluindo data, hora, local e pauta.

### Fornecedores
- **Cadastro de Fornecedores:** Registro de fornecedores, com informações sobre serviços prestados, contato e avaliação.

### Equipamentos
- **Gerenciamento de Equipamentos:** Cadastro e gerenciamento de equipamentos do condomínio, incluindo detalhes técnicos.

### Manutenções
- **Registro de Manutenções:** Cadastro de manutenções programadas ou realizadas nos equipamentos do condomínio, com informações sobre o fornecedor e custo.

### Mensagens
- **Envio e Gerenciamento de Mensagens:** Ferramenta para enviar mensagens e manter a comunicação dentro do condomínio.

### Relatórios
- **Geração de Relatórios:** Ferramenta para gerar relatórios detalhados sobre as atividades e finanças do condomínio.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Jackson (para serialização/deserialização)**
- **Postman (para testes de API)**

## API Endpoints
- **Condomínios:** `/condominios`
- **Unidades:** `/unidades`
- **Usuários:** `/usuarios`
- **Tarefas:** `/tarefas`
- **Ocorrências:** `/ocorrencias`
- **Documentos:** `/api/documento/upload`
- **Receitas:** `/receitas`
- **Despesas:** `/despesas`
- **Reuniões:** `/reunioes`
- **Fornecedores:** `/fornecedores`
- **Equipamentos:** `/equipamentos`
- **Manutenções:** `/manutencoes`
