default: runAll

runAll: prepare build run

run:
	docker-compose up -d

build:
	docker-compose -f docker-compose.build.yml build

prepare:
	./build.sh