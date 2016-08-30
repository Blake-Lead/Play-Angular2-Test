default: mytoolbox

mytoolbox: build images run

run:
	@echo "\n==========> Starting containers...\n"
	docker-compose up -d

images:
	@echo "\n==========> Creating images...\n"
	docker-compose -f docker-compose.build.yml build

build:
	./build.sh
