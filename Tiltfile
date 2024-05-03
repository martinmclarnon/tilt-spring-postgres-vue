# Tiltfile

# Function to create namespace for all worker nodes
def create_namespace_service():
    k8s_yaml('./local-cicd-manifests/namespace.yml')

# Function to build and deploy: Database service
def db_service():
    # Build from Dockerfile
    docker_build('db', context='./src/db', dockerfile='./src/db/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/db.yml')
    # Assign port
    k8s_resource('db', port_forwards='5432:5432', labels="db")

# Function to build and deploy: liquibase update for db service
def db_change_management_service():
    # Build from Dockerfile
    docker_build('db-change-management', context='./src/db-change-management', dockerfile='./src/db-change-management/Dockerfile')
    # Specify the Kubernetes manifest for the deployment
    k8s_yaml('./local-cicd-manifests/db-change-management.yml')
    # Assign port
    k8s_resource('db-change-management', port_forwards='5430:5432', resource_deps=['db'], labels="db")

# Function to build and deploy:BFF service
def bff_service():
    # Build from Dockerfile
    docker_build('bff', context='./src/bff', dockerfile='./src/bff/Dockerfile')
    # Specify the Kubernetes manifest for the BFF deployment
    k8s_yaml('./local-cicd-manifests/bff.yml')
    # Assign port
    k8s_resource('bff', port_forwards='8080:8090', resource_deps=['db'], labels="service")

# Function to build and deploy:API service
def api_service():
    # Build from Dockerfile
    docker_build('api', context='./src/api', dockerfile='./src/api/Dockerfile')
    # Specify the Kubernetes manifest for the API deployment
    k8s_yaml('./local-cicd-manifests/api.yml')
    # Assign port
    k8s_resource('api', port_forwards='8081:8091', resource_deps=['db'], labels="service")

# Function to build and deploy: Frontend service
def frontend_service():
    # Build from Dockerfile
    docker_build('frontend', context='./src/frontend', dockerfile='./src/frontend/Dockerfile')  
    # Specify the Kubernetes manifest for the Frontend deployment
    k8s_yaml('./local-cicd-manifests/frontend.yml')
    # Assign port
    k8s_resource('frontend', port_forwards='8082:80', resource_deps=['db-deployment','bff'], labels="web")

# Function to build and deploy:pgAdmin service
def pgadmin_service():
    # Build from Dockerfile
    docker_build('pgadmin', context='./src/pgadmin', dockerfile='./src/pgadmin/Dockerfile')
    # Specify the Kubernetes manifest for the pgAdmin deployment
    k8s_yaml('./local-cicd-manifests/pgadmin.yml')
    # Assign port
    k8s_resource('pgadmin', port_forwards='8083:80', resource_deps=['frontend'], labels="utility")


create_namespace_service()
db_service()
db_change_management_service()
bff_service()
api_service()
frontend_service()
# pgadmin_service()
