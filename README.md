# Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin

Web Service Restful Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin

# Setup Inicial

Banco de Dados usado Postgre
 - Classe de configuracao do Banco de dados ("luizalabsWS.config.ConfiguracaoDB.java")
 - na linha 36 a 37 setar o driver do DB;
 - na linha 38 configurar o usuário do DB;
 - na linha 39 configurar o password do DB;
 
# Doc API 

- Docs disponíveis no link (https://app.swaggerhub.com/apis/tiagoferezin/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/2)

# Metodos GET

- Listar os discos
(http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/buscar/)

- Venda por Id da Venda
(http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/venda/{idVenda})
-> idVenda é um Long

- Pegar o album pelo Id do album
(http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/album/{idAlbum})
-> idAlbum é uma String

- Coletar as vendas entre as datas em ordem crescente
(http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/vendasEntreDatas/{dataInicial}-{dataFinal})
Exemplo: http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/vendasEntreDatas/10012018-05062018 - Irá pegar as vendas entre o período de 10/01/2018 a 05/06/2018

#Método POST

- Adicionar uma venda já calculando o cashback total e o valor total da venda
(http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/venda/adicionarVenda/)
Passando como parametro um json de venda contendo uma array de albuns e caso exista, o valor do album(no sistema está com o valor do album estático, conforme foi informado);

 





