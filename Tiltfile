# Tiltfile

# Function to create namespace for all worker nodes
def create_namespace_service():
    k8s_yaml('./local-cicd-manifests/namespace.yml')

# Function to build and deploy: Database service
def marketing_db_service():
    # Build from Dockerfile
    docker_build('marketing-db', context='./src/marketing/persistent-storage/db', dockerfile='./src/marketing/persistent-storage/db/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/marketing-db.yml')
    # Assign port
    k8s_resource('marketing-db', port_forwards='5432:5432', labels="persistent-storage")

# Function to build and deploy: liquibase update for db service
def marketing_db_change_management_service():
    # Build from Dockerfile
    docker_build('marketing-db-change-management', context='./src/marketing/persistent-storage/db-change-management', dockerfile='./src/marketing/persistent-storage/db-change-management/Dockerfile')
    # Specify the Kubernetes manifest for the deployment
    k8s_yaml('./local-cicd-manifests/marketing-db-change-management.yml')
    # Assign port
    k8s_resource('marketing-db-change-management', port_forwards='5430:5432', resource_deps=['marketing-db'], labels="persistent-storage")

# Function to build and deploy: Database service
def store_db_service():
    # Build from Dockerfile
    docker_build('store-db', context='./src/store/persistent-storage/db', dockerfile='./src/store/persistent-storage/db/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/store-db.yml')
    # Assign port
    k8s_resource('store-db', port_forwards='5433:5432', labels="persistent-storage")

# Function to build and deploy: liquibase update for db service
def store_db_change_management_service():
    # Build from Dockerfile
    docker_build('store-db-change-management', context='./src/store/persistent-storage/db-change-management', dockerfile='./src/store/persistent-storage/db-change-management/Dockerfile')
    # Specify the Kubernetes manifest for the deployment
    k8s_yaml('./local-cicd-manifests/store-db-change-management.yml')
    # Assign port
    k8s_resource('store-db-change-management', port_forwards='5431:5432', resource_deps=['store-db'], labels="persistent-storage")

# # Function to build and deploy:BFF service
def bff_web_blog_service():
    # Build from Dockerfile
    docker_build('bff-web-blog', context='./src/marketing/bff-blog', dockerfile='./src/marketing/bff-blog/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/bff-web-blog.yml')
    # Assign port
    k8s_resource('bff-web-blog', port_forwards=['8081:8081','5005:5005'], resource_deps=['marketing-db'], labels="service", trigger_mode=TRIGGER_MODE_MANUAL)

# Function to build and deploy:API service
def bff_web_inventory_service():
    # Build from Dockerfile
    docker_build('bff-web-inventory', context='./src/store/bff-inventory', dockerfile='./src/store/bff-inventory/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/bff-web-inventory.yml')
    # Assign port
    k8s_resource('bff-web-inventory', port_forwards=['8082:8082','5006:5006'], resource_deps=['store-db'], labels="service", trigger_mode=TRIGGER_MODE_MANUAL)

# # Function to build and deploy: Frontend service
def store_frontend_service():
    # Build from Dockerfile
    docker_build('store-frontend', context='./src/store/frontend', dockerfile='./src/store/frontend/Dockerfile')  
    # Specify the Kubernetes manifest for the Frontend deployment
    k8s_yaml('./local-cicd-manifests/store-frontend.yml')
    # Assign port
    k8s_resource('store-frontend', port_forwards='8083:80', resource_deps=['bff-web-inventory'], labels="web")

# Function to build and deploy:pgAdmin service
def pgadmin_service():
    # Build from Dockerfile
    # docker_build('pgadmin', context='./local-utilities/pgadmin/', dockerfile='./local-utilities/pgadmin/Dockerfile')
    # Specify the Kubernetes manifest for the pgAdmin deployment
    k8s_yaml('./local-cicd-manifests/pgadmin.yml')
    # Assign port
    k8s_resource('pgadmin', port_forwards='8084:80', resource_deps=['frontend'], labels="utility")

create_namespace_service()
marketing_db_service()
marketing_db_change_management_service()
store_db_service()
store_db_change_management_service()
bff_web_blog_service()
bff_web_inventory_service()
store_frontend_service()
pgadmin_service()
