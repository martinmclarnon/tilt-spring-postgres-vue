# Use the official pgAdmin4 image as the base image
FROM dpage/pgadmin4

# Install Nginx
RUN apt-get update && \
    apt-get install -y nginx

# Remove the default Nginx configuration
RUN rm /etc/nginx/sites-enabled/default

# Create a custom Nginx configuration file
COPY nginx.conf /etc/nginx/sites-available/default
RUN ln -s /etc/nginx/sites-available/default /etc/nginx/sites-enabled/

# Expose the required ports
EXPOSE 80

# Start Nginx and pgAdmin4
CMD service nginx start && /entrypoint.sh
