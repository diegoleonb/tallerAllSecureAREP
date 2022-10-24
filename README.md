# Taller AllSecureAppSpark
## AREP
## Diego Leon
## 2022-2

## Descripción

Este taller tiene como objetivo el desarrollo de una aplicación web con acceso seguro desde el browser de la aplicacion, por lo que, se garantiza autenticación, autorización e integridad de usuarios. Asimismo, vamos a tener dos maquinas virtuales EC2 en AWS que se van a comunicar entre si, garantizando lo mencionado anteriormente entre los servicios.
Para esto se utilizó el framework Spark, el cual permite el desarrollo de aplicaciones web en Java.

## Arquitectura

![](./media/img/Captura6.PNG)

## Pre-requisitos

- [Java](https://www.java.com/es/download/)
- [Maven](https://maven.apache.org/download.cgi)

## Tree

![](./media/img/Captura7.PNG)

## Procedimiento

Se hace mvn package para allSecureAppSpark y lo convertimos a un zip para poderlo subir a las maquinas virtuales EC2. Y lo subimos por medio del comando put entrando a la maquina virtual por medio de sftp.

![](./media/img/Captura1.PNG)

Descomprimimos el zip en la maquina virtual entrando por medio de ssh y usando el comando unzip. Debido a que, queremos ejecutar la aplicacion tenemos que instalar java en la maquina virtual.

![](./media/img/Captura2.PNG)

Corremos la aplicacion en la maquina virtual 1 con el comando:

```
java -cp target/classes:target/dependency/* edu.escuelaing.arep.SparkApp
```

En la maquina virtual 2 corremos la aplicacion con el comando:

```
java -cp target/classes:target/dependency/* edu.escuelaing.arep.SparkAppTwo
```

## Pruebas

![](./media/img/Captura3.PNG)

![](./media/img/Captura4.PNG)

![](./media/img/Captura5.PNG)


## Video

![Funcionamiento](https://drive.google.com/file/d/1ClkH_g6rMZLBTmRuUPGkpLQQ9tp1zPth/view?usp=sharing)


## Licencia

![LICENCIA](License.txt)