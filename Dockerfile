# run command : gradle buildProduct
# before running docker build

FROM nctweb/nct-matlab:0.0.1
MAINTAINER wilson.v@husky.neu.edu

COPY build/output/NCT-Batch /NCT-Batch
WORKDIR /NCT-Batch

CMD ["./start.sh"]
