  const ouvert1 = false;
  const ouvert2 = false;
  const ouvert3 = false;

		$("#accordeon>section:nth-child(1)").click(function(){
			if (ouvert1) {
				$("#accordeon>section:nth-child(1)>article").hide();
				ouvert1 = false;
				ouvert2 = false;
				ouvert3 = false;
			} else {
				$("#accordeon>section:nth-child(1)>article").show();
				$("#accordeon>section:nth-child(2)>article").hide();
				$("#accordeon>section:nth-child(3)>article").hide();
				ouvert1 = true;
			}
			
		});

		$("#accordeon>section:nth-child(2)").click(function(){  
			if (ouvert2) {
				$("#accordeon>section:nth-child(2)>article").hide();
				ouvert1 = false;
				ouvert2 = false;
				ouvert3 = false;
			} else {
				$("#accordeon>section:nth-child(1)>article").hide();
				$("#accordeon>section:nth-child(2)>article").show();
				$("#accordeon>section:nth-child(3)>article").hide();
				ouvert2 = true;
			}
			

		});
		$("#accordeon>section:nth-child(3)").click(function(){  
			if (ouvert3) {
				$("#accordeon>section:nth-child(3)>article").hide();
				ouvert1 = false;
				ouvert2 = false;
				ouvert3 = false;
			} else {
				$("#accordeon>section:nth-child(1)>article").hide();
				$("#accordeon>section:nth-child(2)>article").hide();
				$("#accordeon>section:nth-child(3)>article").show();
				ouvert3 = true;
			}

		});
