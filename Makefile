default: mytoolbox

mytoolbox: build images run

run:
	docker-compose up -d

images:
	docker-compose -f docker-compose.build.yml build

build:
	./build.sh
