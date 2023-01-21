# appRatingProjet
Documentation API 
Membres du groupe : 
SANA Cheik
KIENDREBEOGO Théophile 

### Routes et paramètres ### 
## Start 1 
Route => http://localhost:8080/api/rating 
Description => Permet de lister tous les critères d’évaluation ; 
Type => GET; 
Paramètres => Néant ; 
Retour => une liste [] de critères d’évaluation ou si rien n’a été créer juste {} ; 
## End 1
## Start 2 
Route => http://localhost:8080/api/rate 
Description => Permet de lister toutes les notes des critères d’évaluation ; 
Type => GET; 
Paramètres => Néant ; 
Retour => une liste [] de notes des critères d’évaluation ou si rien n’a été créer juste {} ; 
## End 2
## Start 3 
Route => http://localhost:8080/api/rating/{id} 
Description => Permet de renvoyer le critère d’évaluation concerné ; 
Type => GET; 
Paramètres => Id du critère d’évaluation ; 
Retour => un critère d’évaluation ou si rien n’a été créer juste {} ; 
## End 3
## Start 4 
Route => http://localhost:8080/api/rate/{id} 
Description => Permet de renvoyer la note d’un critère d’évaluation ; 
Type => GET; 
Paramètres => id de la note ; 
Retour => une note du critère d’évaluation ou si rien n’a été créer juste {} ; 
## End 4

## Start 5 
Route => http://localhost:8080/api/rating 
Description => Permet de créer un critère d’évaluation ; 
Type => POST; 
Paramètres => JSON avec les valeurs souhaitées affecter aux bonnes colonnes
{
    "denomination": "valeur souhaitée",
    "descrdescription": "valeur souhaitée"
}; 
Retour => status 200 OK ; 
## End 5
## Start 6
Route => http://localhost:8080/api/rate 
Description => Permet de noter un critère d’évaluation ; 
Type => POST; 
Paramètres => JSON avec les valeurs souhaitées affecter aux bonnes colonnes
{
    "note": "valeur souhaitée",
    "comment": "valeur souhaitée",
    "critere": {
    "id": "id du critere concerné",
    "denomination": "valeur du critere concerné",
    "descrdescription": "valeur du critere concerné"
}
}
; 
Retour => status 200 OK ; 
## End 6
## Start 7 
Route => http://localhost:8080/api/rating/{id} 
Description => Permet de mettre à jour le critère d’évaluation concerné ; 
Type => PUT; 
Paramètres => Id du critère d’évaluation 
{
    "denomination": "valeur modifiée",
    "descrdescription": "valeur modifiée "
}; 
Retour => status 200 OK ; 
## End 7
## Start 8 
Route => http://localhost:8080/api/rate/{id} 
Description => Permet de mettre à jour la note d’un critère d’évaluation ; 
Type => PUT; 
Paramètres => id de la note 
{
    "note": "valeur modifiée",
    "comment": "valeur modifiée ",
    "critere": {
    "id": "id du critere concerné",
    "denomination": "valeur du critere concerné",
    "descrdescription": "valeur du critere concerné"
}
} ;
Retour => status 200 OK ; 
## End 8
## Start 9 
Route => http://localhost:8080/api/rating/{id} 
Description => Permet de supprimer le critère d’évaluation concerné ; 
Type => DELETE; 
Paramètres => Id du critère d’évaluation ; 
Retour => status 200 OK ; 
## End 9
## Start 10 
Route => http://localhost:8080/api/rate/{id} 
Description => Permet de supprimer la note d’un critère d’évaluation ; 
Type => DELETE; 
Paramètres => id de la note ; 
Retour => status 200 OK ; 
## End 10
