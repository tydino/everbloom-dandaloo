package com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber;
// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.animal.chicken.ChickenModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class daggerStabberModel extends EntityModel<DaggerStabberRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("everbloomdandaloo", "dagger_stabber"), "main");
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart stabber1;
	private final ModelPart stabber2;
	private final ModelPart stabber3;
	private final ModelPart stabber4;
	private final ModelPart rightear;
	private final ModelPart leftear;
	private final ModelPart toplip;
	private final ModelPart leftlip;
	private final ModelPart bottomlip;
	private final ModelPart rightlip;
	private final ModelPart eyelids;
	private final ModelPart pupils;
	private final ModelPart leftfoot;
	private final ModelPart leftshin;
	private final ModelPart leftthigh;
	private final ModelPart leftrighttoe;
	private final ModelPart leftlefttoe;
	private final ModelPart rightfoot;
	private final ModelPart rightshin;
	private final ModelPart rightthigh;
	private final ModelPart rightrighttoe;
	private final ModelPart rightlefttoe;

	final KeyframeAnimation idle;
	final KeyframeAnimation blink;

	public daggerStabberModel(ModelPart root) {
		super(root);
		this.body = root.getChild("body");
		this.neck = this.body.getChild("neck");
		this.head = this.neck.getChild("head");
		this.stabber1 = this.head.getChild("stabber1");
		this.stabber2 = this.stabber1.getChild("stabber2");
		this.stabber3 = this.stabber2.getChild("stabber3");
		this.stabber4 = this.stabber3.getChild("stabber4");
		this.rightear = this.head.getChild("rightear");
		this.leftear = this.head.getChild("leftear");
		this.toplip = this.head.getChild("toplip");
		this.leftlip = this.head.getChild("leftlip");
		this.bottomlip = this.head.getChild("bottomlip");
		this.rightlip = this.head.getChild("rightlip");
		this.eyelids = this.head.getChild("eyelids");
		this.pupils = this.head.getChild("pupils");
		this.leftfoot = root.getChild("leftfoot");
		this.leftshin = this.leftfoot.getChild("leftshin");
		this.leftthigh = this.leftshin.getChild("leftthigh");
		this.leftrighttoe = this.leftfoot.getChild("leftrighttoe");
		this.leftlefttoe = this.leftfoot.getChild("leftlefttoe");
		this.rightfoot = root.getChild("rightfoot");
		this.rightshin = this.rightfoot.getChild("rightshin");
		this.rightthigh = this.rightshin.getChild("rightthigh");
		this.rightrighttoe = this.rightfoot.getChild("rightrighttoe");
		this.rightlefttoe = this.rightfoot.getChild("rightlefttoe");

		this.idle = DaggerStabberAnimations.IDLE.bake(root);
		this.blink = DaggerStabberAnimations.BLINK.bake(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(2, 0).addBox(-3.5F, -4.0F, -6.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 2.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(8, 12).addBox(-2.5F, -13.0F, -1.0F, 5.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(4, 29).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(8, 10).addBox(-2.0F, -5.0F, -4.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(2.0F, -5.0F, -4.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 16).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 18).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 1.0F));

		PartDefinition stabber1 = head.addOrReplaceChild("stabber1", CubeListBuilder.create().texOffs(32, 2).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

		PartDefinition stabber2 = stabber1.addOrReplaceChild("stabber2", CubeListBuilder.create().texOffs(33, 12).addBox(-1.5F, -1.5F, -6.25F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition stabber3 = stabber2.addOrReplaceChild("stabber3", CubeListBuilder.create().texOffs(34, 21).addBox(-1.0F, -1.0F, -6.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition stabber4 = stabber3.addOrReplaceChild("stabber4", CubeListBuilder.create().texOffs(35, 29).addBox(-0.5F, -0.5F, -6.75F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(24, 27).addBox(-3.0F, -5.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, 1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -5.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition toplip = head.addOrReplaceChild("toplip", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -4.01F));

		PartDefinition leftlip = head.addOrReplaceChild("leftlip", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -4.01F));

		PartDefinition bottomlip = head.addOrReplaceChild("bottomlip", CubeListBuilder.create().texOffs(0, 5).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.01F));

		PartDefinition rightlip = head.addOrReplaceChild("rightlip", CubeListBuilder.create().texOffs(2, 1).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, -4.01F));

		PartDefinition eyelids = head.addOrReplaceChild("eyelids", CubeListBuilder.create().texOffs(4, -1).addBox(3.02F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-3.02F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -2.0F));

		PartDefinition pupils = head.addOrReplaceChild("pupils", CubeListBuilder.create().texOffs(4, 2).addBox(3.01F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 2).addBox(-3.01F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -2.0F));

		PartDefinition leftfoot = partdefinition.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(35, 36).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 23.0F, 2.0F));

		PartDefinition leftshin = leftfoot.addOrReplaceChild("leftshin", CubeListBuilder.create().texOffs(29, 12).addBox(-0.5F, -6.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leftthigh = leftshin.addOrReplaceChild("leftthigh", CubeListBuilder.create().texOffs(27, 20).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftrighttoe = leftfoot.addOrReplaceChild("leftrighttoe", CubeListBuilder.create().texOffs(33, 37).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -3.0F));

		PartDefinition leftlefttoe = leftfoot.addOrReplaceChild("leftlefttoe", CubeListBuilder.create().texOffs(45, 37).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition rightfoot = partdefinition.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(35, 36).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 23.0F, 2.0F));

		PartDefinition rightshin = rightfoot.addOrReplaceChild("rightshin", CubeListBuilder.create().texOffs(29, 12).addBox(-0.5F, -6.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition rightthigh = rightshin.addOrReplaceChild("rightthigh", CubeListBuilder.create().texOffs(27, 20).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightrighttoe = rightfoot.addOrReplaceChild("rightrighttoe", CubeListBuilder.create().texOffs(33, 37).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -3.0F));

		PartDefinition rightlefttoe = rightfoot.addOrReplaceChild("rightlefttoe", CubeListBuilder.create().texOffs(45, 37).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 52, 42);
	}

	@Override
	public void setupAnim(DaggerStabberRenderState state) {
		super.setupAnim(state);

		if(state.idleAnimation.isStarted()){
			this.idle.apply(state.idleAnimation, state.ageInTicks);
		}
		if(state.blinkAnimation.isStarted()){
			this.blink.apply(state.blinkAnimation, state.ageInTicks);
		}

		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
	}
}