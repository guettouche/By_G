<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project_Web: Service REST de transactions SEPA</title>
    </head>
    <body>
    	
        
      
                <h1>Page d'accueil</h1>
                <h3>Project_Web: Service REST de transactions SEPA</h3>
                <em>Creer le 23 mars 2017</em>
                <p>Realiser par <a href="../guettouche-islam.comlu.com">Guettouche Islam</a></p>
                <table ><tr> 
                </tr></table>
                <div >
                        <h3>Liens disponibles:</h3>
                        <ul >
                        <li><strong>Detail : Renvoie un flux XML contenant la liste des transactions détaillées</strong>: 
                            <a href="detail" style=\"color:black;\">/detail</a></li><p/>

                        <li><strong>Resume : Renvoie un flux XML contenant la liste des transactions résumées</strong>: 
                            <a href="detail" style=\"color:black;\">/resume</a></li><p/>

                        <li><strong>Stats : Afficher une synthèse des transactions stockées, avec les informations suivantes : 
                                                Nombre de transactions, montant total des transactions</strong>: 
                            <a href="detail" style=\"color:black;\">/stats</a></li><p/>

                        <li><strong>Trx+Id : Renvoie un flux XML décrivant le détail de la transaction d’identifiant id
                                                avec id = PmtId</strong>: 
                            <a href="detail" style=\"color:black;\">/trx/id</a></li><p/>

                        <li><strong>Depot :Reçoit un flux XML décrivant une transaction. <br> 
                                                Un message de retour indique le résultat de l'opération, avec le numéro 
                                                d'identification en cas de succès, et un message d'erreur sinon.</strong>: 
                            <a href="detail" style=\"color:black;\">/depot</a></li><p/>




                        </ul>
                </div>
    </body>
</html>
