FROM nginx:latest

# Copy angular 2 files
COPY ./dist /usr/share/nginx/html/dist
COPY ./app/views /usr/share/nginx/html/app/views
COPY ./app/styles /usr/share/nginx/html/app/styles
COPY systemjs.config.js /usr/share/nginx/html
COPY ./node_modules /usr/share/nginx/html/node_modules
COPY index.html /usr/share/nginx/html

# Copy custom configuration & start script
COPY docker/nginx.conf /etc/nginx/nginx.conf
COPY docker/env-build.sh .

RUN chmod +x env-build.sh

CMD ["./env-build.sh"]
