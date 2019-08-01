# run command : gradle buildProduct
# before running docker build

FROM nctweb/hadoop:0.0.2
MAINTAINER wilson.v@husky.neu.edu

COPY build/output/NCT-Batch /NCT-Batch
COPY plugins /NCT-Batch/plugins
WORKDIR /NCT-Batch

CMD ["./start.sh"]
