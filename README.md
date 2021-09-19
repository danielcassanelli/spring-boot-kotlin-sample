# spring-boot-kotlin-sample
Spring boot sample code with kotlin and gradle

Model   <->      UseCase     <->     API
                    ^
                    .
                    .
                    .
              Repository(DTOs to Model)
                  Infra  
                    ^
                   / \
                  /   \
                 /     \
       Remote(Json)     Database(Entity)

