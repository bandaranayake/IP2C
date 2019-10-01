init <- function(path){
  df <- read.csv(path, comment.char = '#', header = FALSE)
  names(df) <- c("IP From", "IP To", "Registry", "Assigned", "Ctry", "Cntry", "Country")
  return(df)
}

getIPDec <- function(ip){
  splitted <- strsplit(ip, '\\.')
  multiplier <- c(256*256*256, 256*256, 256, 1)
  splitted <- as.numeric(unlist(splitted))
  return(sum(splitted*multiplier))
}

getRecord <- function(path, ip){
  df <- init(path)
  ip <- getIPDec(ip)
  for(i in 1 : length(df[,"IP From"])){
    if(df[i,"IP From"] <= ip && ip <= df[i,"IP To"]){
      return(df[i,])
    }
  }
}

getCountry <- function(path, ip){
  record <- getRecord(path, ip)
  cat(ip, as.character(record$"Country") , as.character(record$"Ctry"), as.character(record$"Cntry"))
}

cat("IP2C - Solves IPs to Country codes and names\nUsage: [Path] [IP]\n\n")
args = commandArgs(trailingOnly=TRUE)

if (length(args)<2) {
  stop("Invalid Syntax", call.=FALSE)
} else if (length(args)==2) {
  getCountry( args[1], args[2])
}