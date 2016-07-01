### Sistema de Métricas
Delio Damin
Felipe Scherer

##### 1. POST

#### NOVA MEDIÇÃO
http://localhost:9000/medicao

{
    "nome":"REDE"
}

####  NOVA METRICA
http://localhost:9000/metricas/

{
    "nome":"Metrica4",
    "medicoes_id":"1,2,3,4",
     "host": "Server02"
}

#### NOVO ALERTA
CAMPO valores: INSERIR NO MÁXIMO 3 VALORES SEPARADOS POR VÍRGULA
http://localhost:9000/alerta

{
    "nome":"alerta2",
    "metrica_id":19,
    "valores":"45,67,89"
}


##### 2. GET

#### CONSULTAR ALERTA
http://localhost:9000/alerta/id

Exemplo:
http://localhost:9000/alerta/3 
[{"id":3,"nome":"alerta3","created":"2016-06-21","metrica":"20","valores":">15, >40"}]


#### CONSULTAR METRICA 
http://localhost:9000/metricas/id 

Exemplo:
http://localhost:9000/metricas/20
[{"id":20,"nome":"Metrica5","created":"2016-06-22","medicoes":"10,11","host":"Server02"}]


#### CONSULTAR TABELA MEDIÇÕES
http://localhost:9000/medicao/id 

Exemplo:
http://localhost:9000/medicao/10
[{"id":10,"nome":"REDE","created":"2016-06-22"}]


#### EXECUTAR APP E CONSULTAR HISTÓRICO ALERTAS/ALARMES
localhost:9000/app 

O histórico de alertas é armazenado no seguinte arquivo TXT:
"C:\TEMP\Alertas.txt"

A verificação é realizada a cada requisição HTTP Get em http://localhost:9000/app 
 

