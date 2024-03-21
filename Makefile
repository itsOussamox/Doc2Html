

NAME = DOC2HTML
IMAGE_NAME = DOC2IMAGE

all: 
	docker run -d -p 8080:8080 --name $(NAME) $(IMAGE_NAME)

build:
	docker build -t $(IMAGE_NAME) .

exec:
	docker exec -it $(NAME) /bin/bash

clean:
	docker rm -f $(NAME)

fclean: clean
	docker rmi $(IMAGE_NAME)

fresh: clean build all
