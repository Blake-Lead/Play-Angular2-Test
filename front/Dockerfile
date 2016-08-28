FROM nginx:latest

# Copy angular files
COPY ./app /usr/share/nginx/html
COPY ./bower_components /usr/share/nginx/html/bower_components

# Copy custom configuration
COPY nginx.conf /etc/nginx/nginx.conf
COPY .htpasswd /etc/nginx

COPY env-build.sh .

RUN chmod +x env-build.sh

CMD ["./env-build.sh"]
