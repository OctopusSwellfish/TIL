TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			});


//로 만들고

//string[] 으로 뺄떄는

String[] result = ts.toArray(new String[ts.size()]);

//지금같은 경우는 스트링 정려할때 큰 게 앞으로오는것이다
//PriorituQyeye 도 만드는 방식은 
