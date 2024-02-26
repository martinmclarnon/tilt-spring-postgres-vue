# Use the official PostgreSQL image from Docker Hub
FROM postgres:latest

# Environment variables for PostgreSQL configuration 
# hydrated at deployment via manifest
ENV POSTGRES_DB restful-api
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD admin

# Expose the PostgreSQL port
EXPOSE 5432